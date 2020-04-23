# Http4k Test Drive

![](https://github.com/abedurftig/http4k-test-drive/workflows/CI/badge.svg)

Giving [Http4k](https://www.http4k.org/) a test drive.

## Build

Run `./gradlew build` to build and test the project.

## Run the server

Run `java -jar ./build/libs/http4k-test-drive-all.jar` to start the server.
Note, it will try to start on port 8080, so make sure no other process is using that port.

- Browse to `http://localhost:8080/greeting`, you should see `Hello World!`.
- Browse to `http://localhost:8080/add?first=1&second=9`, you should see `The answer is 10`
