import { Component, OnInit } from '@angular/core';
import { IdeasService } from "../../dataService/ideas.service";
import { SignInService } from 'src/dataService/sign-in.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ideas',
  templateUrl: './ideas.component.html',
  styleUrls: ['./ideas.component.scss']
})
export class IdeasComponent implements OnInit {

  ideaDetailsTitle = "";
  ideaDetailsData = "";
  addIdeaTitle = '';
  addIdeaModal = '';
  ideasData = [];
  userDetails;
  constructor(private _ideasService: IdeasService,private _signinService:SignInService,  private router:Router) { }

  ngOnInit() {
    this.getIdeaData();    
    this.userDetails=this._signinService.userDetails;
    console.log(this.userDetails);
  }

  knowMoreClick(data) {
    console.log('data =>', data);
    this.ideaDetailsData = data.details;
    this.ideaDetailsTitle = data.name;
  }

  addIdea() {
    this.addIdeaModal = '';
    this.addIdeaTitle = 'Add Idea';
  }

  signMeOut(){
    localStorage.clear();
    this.router.navigate(['/signIn']);
  }

  getIdeaData() {
    this._ideasService.getIdeasData(this._signinService.userDetails).subscribe(
      data => {
        this.ideasData = data;
      }
    );
  }
}
