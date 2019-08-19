import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }
  

  authenticateUser(user):any
  {
    console.log("in service");
    console.log("in authenticateUserser " +user);
    return this.http.post("http://140.238.163.105:8080/userloginservice/api/v1/user",user); //.subscribe((user:any) => 
                                                                  //   {
                                                                  //   console.log(user);
                                                                  //     }                                                                                                                                                                                                                                                                                                                     );
                                                                  // console.log(user);

  }

  getRecommendations(emailId):any{
    return this.http.get(`http://140.238.163.105:8080/recommendationservice/rest/neo4j/idea/ideas/${emailId}`);
  }

  getRecommendationsByApplied(emailId):any{
    return this.http.get(`http://140.238.163.105:8080/recommendationservice/rest/neo4j/idea/recommendidea/${emailId}`);

  }
}
