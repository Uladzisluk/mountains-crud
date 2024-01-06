/**
 * Represents single edition in form.
 */
export interface PeakForm{
  /**
   * Name of the peak.
   */
  name: string;

  /**
   * Height of the peak
   */
  height: number;

  /**
   * UUID of the peak's range.
   */
  range: string;
}
