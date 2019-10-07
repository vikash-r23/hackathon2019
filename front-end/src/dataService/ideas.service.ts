import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root'
})
export class IdeasService {

  private _mockIdeaServiceURL = './assets/mockData/ideaData.json';

  constructor(private _httpCall: HttpClient) { }

  getIdeasData(): Observable<any> {
    return this._httpCall.get<any>(this._mockIdeaServiceURL);
  }
}
