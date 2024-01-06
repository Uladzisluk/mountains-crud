/**
 * Represents single peak in list.
 */
export interface PeakDetails{
  /**
   * Unique id identifying peak.
   */
  id: string;

  /**
   * Name of the peak.
   */
  name: string;

  /**
   * Height of the peak.
   */
  height: number;

  /**
   * Name of peak's range.
   */
  range: string;

  /**
   * UUID of peak's range.
   */
  rangeUUID: string;
}
