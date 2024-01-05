import { Injectable } from '@angular/core';
import {Peaks} from "../model/peaks";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class PeakService {
  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all peaks.
   *
   * @return list of peaks
   */
  getPeaks(): Observable<Peaks> {
    return this.http.get<Peaks>('/api/peaks');
  }

  /**
   * Removes single peak.
   *
   * @param uuid peak's id
   */
  deletePeak(uuid: string): Observable<any> {
    return this.http.delete('/api/peaks/' + uuid);
  }
}
