import {Peak} from "./peak";

/**
 * GET peaks response. Contains list of available peaks. Can be used to list particular range's peaks as
 * well as all peaks in the game.
 */
export interface Peaks {

  /**
   * Name of the selected peaks.
   */
  peaks:Peak[];

}
