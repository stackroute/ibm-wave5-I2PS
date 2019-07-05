import { Component, OnInit } from '@angular/core';
import { PostIdeaComponent } from '../post-idea/post-idea.component';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'app-new-idea-profile',
  templateUrl: './new-idea-profile.component.html',
  styleUrls: ['./new-idea-profile.component.css']
})
export class NewIdeaProfileComponent {

  constructor(public dialog: MatDialog) { }

  openDialog(): void {
    const dialogRef = this.dialog.open(PostIdeaComponent, {
      width: '800px',
    });

    dialogRef.afterClosed().subscribe(result => {
      
      console.log('The dialog was closed');
    });
  }
}
