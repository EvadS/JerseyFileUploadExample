# JerseyFileUploadExample #

## Project ##

This project is a sample project for File Uploads with Jersey and Spring Boot.

## Example ##

```
curl --verbose --form title="File Title" --form description="File Description" --form file=@"myfile.txt" http://localhost:8080/files/upload
```
