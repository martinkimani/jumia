import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';  
import { Observable } from 'rxjs';  

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

    private baseUrl = 'http://localhost:9000/customers';  
  
    constructor(private http:HttpClient) { }

    getCustomers(country?:String,is_valid?:boolean): Observable<any> {

        let params = {};
        if(country && !is_valid) {
            params = {'country':country}
        } else if(!country && is_valid) {
            params = {'is_valid':is_valid}
        }else if(country && is_valid) {
            params = {'country':country,'is_valid':is_valid}
        }
        return this.http.get(this.baseUrl,{
                params: params
        });  
      } 
}