# Jumia Project

This project is a holder project which has two modules the backend and frontend.

The project can be deployed as a fat jar or as a docker image.

clone the project https://github.com/martinkimani/jumia.git

## Environment Variable

For running as a fat jar the project requires one environment variable SQLITEDB_PATH whose value is the absolute path of the location of the sqlite database in the file system. 
e.g /home/martin/sqlite/sample.db

Docker does not require the variable.

## Build Fat jar

Navigate to the jumia-backend folder and run `mnv clean package` to generate the fat jar. It will be stored in the `target/` directory.

## Build Docker Image

while still at the same jumia-backend folder generate the fat jar as explained above.

Then run `docker build -f src/docker/Dockerfile . -t jumia/jumia-interview:1.0` . A docker image will be generated.

Run `docker images` and you should see the generated image jumia/jumia-interview:1.0 among the docker images listed.

## Running Fat jar

Run `java -jar your_generated_jar.jar`.

## Running in docker 

Run `docker run -p 9000:9000 -t jumia/jumia-interview:1.0`.

Finally open your browser and go to localhost:9000 to access the web application

## Further help

For further assistance feel free to contact me on my email: khim.mwangi@gmail.com
