import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class RecentIdeasService {

  constructor(private httpclient: HttpClient) { }

  getRecentIdeas():any{
    return this.httpclient.get("http://13.232.118.81:8080/ideahubservice/api/v1/ideas");
  }

  getIdeaDetails(value):any{
    console.log(value);
    return this.httpclient.get(`http://13.232.118.81:8080/ideahubservice/api/v1/idea/${value}`)
  }

  sendToInnovator(title,emailId):any{
    this.httpclient.put(`http://13.232.118.81:8080/innovatormanagementservice/api/v1/idea/${title}/${emailId}`,{}).subscribe();
    this.httpclient.post(`http://13.232.118.81:8080/recommendationservice/rest/neo4j/idea/user/${title}/${emailId}`,{}).subscribe();
    console.log("came");

  }

  getAppliedServiceProviders(title):any
  {
    console.log("here applied people",title)
    return this.httpclient.get(`http://13.232.118.81:8080/innovatormanagementservice/api/v1//serviceProviders/${title}`);
    console.log("after url")
  }

  approveOrRejectSP(title,emailId,status):any{
this.httpclient.put(`http://13.232.118.81:8080/innovatormanagementservice/api/v1/serviceProviders/${title}/${emailId}/${status}`,{}).subscribe();
console.log("coming");
  }
}
