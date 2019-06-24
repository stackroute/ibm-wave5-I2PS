import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import { LoginService } from '../login.service';
@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

constructor(private loginService:LoginService, private route: ActivatedRoute,private router:Router) { }
  arrayOfUser:any=[];


  ngOnInit() {

    // this.subscribe(data=>
    //   {
    //    console.log(data)
    //    this.arrayOfMusic=data;
    // });
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


