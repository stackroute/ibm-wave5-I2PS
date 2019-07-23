import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationServiceService {

  constructor(private http:HttpClient) { }

  getServiceProvider():any{
    console.log("getting")
    return this.http.get("http://13.232.118.81:8080/serviceproviderprofileservice/api/v1/serviceproviders");
  }

  addServiceProvider(value):any{
    this.http.post("http://13.232.118.81:8080/serviceproviderprofileservice/api/v1/serviceprovider",value).subscribe(console.log);
    console.log("came how many times ???");

  }
  getByEmailIdForServiceProvider(emailId):any{
    console.log("in getbyemail of reg service "+emailId);
    return this.http.get(`http://13.232.118.81:8080/serviceproviderprofileservice/api/v1/getByEmailId/${emailId}`);
  }

  getInnovatorProfile():any{
    console.log("gettinginnovatorprofile ")
    return this.http.get("http://13.232.118.81:8080/innovatorprofileservice/api/v1/innovatorprofiles");

  }
  addInnovatorProfile(value):any{
    this.http.post("http://l13.232.118.81:8080/innovatorprofileservice/api/v1/innovatorprofile",value).subscribe();
    console.log("came");

  }

  getByEmailIdForInnovatorProfile(emailId):any{
    console.log("in getbyemail of reg service "+emailId);
    return this.http.get(`http://13.232.118.81:8080/innovatorprofileservice/api/v1/innovatorprofile/${emailId}`);
  }
  

  getIdeasPostedByInnovator(emailId):any{
    console.log("in reg servive for getideas posted by innovator "+emailId);
    return this.http.get(`http://13.232.118.81:8080/ideahubservice/api/v1/getIdeaByEmailId/${emailId}`);
  }

}

