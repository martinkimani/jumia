import { Component, OnInit } from '@angular/core';
import { CustomerService } from './customer.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'jumia-frontend';
  page = 1;
  pageSize = 10;
  country?: String;
  valid?: any;

  customersArray: any[] = [];

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.customerService.getCustomers().subscribe(data => this.customersArray = data);
  }

  searchCustomers(country_value?: String) {
    this.country = country_value;
    this.customerService.getCustomers(this.country, this.valid).subscribe(data => this.customersArray = data);
  }

  getValueFromSelect(value: any) {
    if (value === 'All') {
      this.valid = null;
    } else {
      this.valid = value;
    }
  }
}
