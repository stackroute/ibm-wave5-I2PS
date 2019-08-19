import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class IntelligentserviceService {

  constructor(private http:HttpClient) 
  {

  }


  getServiceProviders(value):any {
    console.log("in intelligent service")
    var url=`http://140.238.163.105:8080/intelligentservice/api/v1/intelligentService/${value}`;
    console.log("after the url")
    return this.http.get(url);
  }
}
