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
    return this.http.post("http://localhost:8088/api/v1/user",user); //.subscribe((user:any) => 
                                                                  //   {
                                                                  //   console.log(user);
                                                                  //     }                                                                                                                                                                                                                                                                                                                     );
                                                                  // console.log(user);

  }
}