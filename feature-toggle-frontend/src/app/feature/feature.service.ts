import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Feature } from './feature';
import { Observable, catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeatureService {
  readonly baseUrl: string = "http://localhost:8080/api/v1/"


  constructor(private http: HttpClient) { }

  public getFeatures(): Observable<Feature[]> {
    return this.http.get<Feature[]>(this.baseUrl + "features")
  }

  public createFeature(feature: Feature): Observable<Feature> {
    return this.http.post<Feature>(this.baseUrl + "features", feature);
  }
}
