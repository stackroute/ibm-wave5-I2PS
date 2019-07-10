import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-innovator-dashboard',
  templateUrl: './innovator-dashboard.component.html',
  styleUrls: ['./innovator-dashboard.component.scss']
})
export class InnovatorDashboardComponent implements OnInit {

  constructor(private router:Router) { }
  

  ngOnInit() {
  }

  routeDetail()
  {
    this.router.navigateByUrl('/postIdea')
  }
}
