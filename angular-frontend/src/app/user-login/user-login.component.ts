import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import { LoginService } from '../login.service';
@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

constructor(private loginService:LoginService, private route: ActivatedRoute, private router:Router) { }
  arrayOfUser:any=[];


  ngOnInit() {
    console.log("in ngoninit")
  }

  

  authenticateUser(userName, role, password) {
    console.log("in authenticateUser " + userName + role +password);
    let userdata = {
      userName:userName,
      role: role,
      password: password
    }
    this.loginService.authenticateUser(userdata);
  }

  userName: string;
  password: string;
  role:string;
  
  login() : void {

    if(this.userName =="" || this.password == ""|| this.role==""){
    //  this.router.navigate(["register"]);
    // }else { 
      alert("Null Credentials");
    }
  }
}


