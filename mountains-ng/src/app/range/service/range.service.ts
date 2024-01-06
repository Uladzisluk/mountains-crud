import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ranges} from "../model/ranges";
import {RangeForm} from "../model/range-form";
import {RangeDetails} from "../model/range-details";

@Injectable()
export class RangeService {

  /**
   * @param http HTTP Client
   */
  constructor(private http: HttpClient) { }

  /**
   * Fetches all ranges.
   * @return list of users
   */
  getRanges(): Observable<Ranges> {
    return this.http.get<Ranges>('/api/ranges');
  }

  /**
   * Fetches single range.
   *
   * @param uuid range's id
   * @return single range
   */
  getRange(uuid: string): Observable<RangeDetails> {
    return this.http.get<RangeDetails>('/api/ranges/' + uuid);
  }

  /**
   * Removes single range.
   *
   * @param uuid range's id
   */
  deleteRange(uuid: string): Observable<any> {
    return this.http.delete('/api/ranges/' + uuid);
  }

  /**
   * Updates single range.
   *
   * @param uuid range's id
   * @param request request body
   */
  putRange(uuid: string, request: RangeForm): Observable<any>{
    return this.http.put('api/ranges/' + uuid, request);
  }
}
