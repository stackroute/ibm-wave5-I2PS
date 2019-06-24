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

    // this.subscribe(data=>
    //   {
    //    console.log(data)
    //    this.arrayOfUser=data;
    // });
  }

  // authenticateUser(value) {
  //   console.log("in addtowish" + value.artist.name);
  //   let myMusic = {
  //     trackId:  value.listeners,
  //     trackName: value.name,
  //     comments:value.artist.name
  //   }
  //   this.musixService.addToWishList(myMusic);
  // }

  userName: string;
  password: string;
  role:string;
  
  login() : void {
    if(this.userName =="" || this.password == ""|| this.role==""){
    //  this.router.navigate(["register"]);
    // }else { 
      alert("Invalid credentials");
    }
  }
}


