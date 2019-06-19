import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  username: string;
  password: string;
  
  login() : void {
    if(this.username == 'admin' && this.password == 'admin'){
     this.router.navigate(["register"]);
    }else {
      alert("Invalid credentials");
    }
  }
}


