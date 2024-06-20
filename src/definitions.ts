export interface CapacitorIntentOptions {
  action: string;
  packageName: string;
  className: string;
  PROGRAM_GUID: string;
  RELIANT_GUID: string;
  REQUEST_CODE: string;
  REQUEST_DATA: string;
}

export interface CapacitorIntentPlugin {
  pluginName: string;
  startActivityForResult(options: CapacitorIntentOptions): Promise<any>;
}
