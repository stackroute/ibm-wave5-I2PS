import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http:HttpClient) { }

getServiceProvider():any{
  console.log("getting")
  return this.http.get("http://localhost:8077/api/v1/serviceproviders");
}

addServiceProvider(value):any{
  this.http.post("http://localhost:8077/api/v1/serviceprovider",value).subscribe();
  console.log("came");

}

}
