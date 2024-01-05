import { Injectable } from '@angular/core';
import {Peaks} from "../model/peaks";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {PeakDetails} from "../model/peak-details";

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
   * Fetches single peaks.
   *
   * @param uuid peak's id
   * @return single peaks
   */
  getPeak(uuid: string): Observable<PeakDetails> {
    return this.http.get<PeakDetails>('/api/peaks/' + uuid);
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
