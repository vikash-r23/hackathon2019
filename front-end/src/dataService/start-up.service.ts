import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root'
})
export class StartUpService {

  private _mockStartUpServiceURL = './assets/mockData/startUpPortfolio.json';

  constructor(private _httpCall: HttpClient) { }

  getStartUpPortfolioData(): Observable<any> {
    return this._httpCall.get<any>(this._mockStartUpServiceURL);
  }
}
