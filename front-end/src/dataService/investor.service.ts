import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root'
})
export class InvestorService {

  private _mockInvestorServiceURL = './assets/mockData/investorPortfolio.json';

  constructor(private _httpCall: HttpClient) { }

  getInvestorPortfolioData(): Observable<any> {
    return this._httpCall.get<any>(this._mockInvestorServiceURL);
  }
}
