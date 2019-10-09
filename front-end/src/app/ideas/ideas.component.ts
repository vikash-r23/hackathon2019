import { Component, OnInit } from '@angular/core';
import { IdeasService } from "../../dataService/ideas.service";
import { SignInService } from 'src/dataService/sign-in.service';

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
  constructor(private _ideasService: IdeasService,private _signinService:SignInService) { }

  ngOnInit() {
    this.getIdeaData();    
    this.userDetails=this._signinService.userDetails;
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

  getIdeaData() {
    this._ideasService.getIdeasData().subscribe(
      data => {
        this.ideasData = data.ideasData;
      }
    );
  }
}
