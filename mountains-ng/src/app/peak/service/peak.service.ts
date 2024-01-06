import { Injectable } from '@angular/core';
import {Peaks} from "../model/peaks";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {PeakDetails} from "../model/peak-details";
import {PeakForm} from "../model/peak-form";

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
   * Fetches all peaks from range.
   * @param uuid range's id
   *  @return list of peaks
   */
  getRangePeaks(uuid: string): Observable<Peaks>{
    return this.http.get<Peaks>('/api/ranges/'+ uuid + '/peaks');
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

  /**
   * Updates single peak.
   *
   * @param uuid peak's id
   * @param request request body
   */
  putPeak(uuid: string, request: PeakForm): Observable<any> {
    return this.http.put('/api/peaks/' + uuid, request);
  }
}
