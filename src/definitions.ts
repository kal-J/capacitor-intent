export interface CapacitorIntentOptions {
  action?: string;
}

export interface CapacitorIntentPlugin {
  pluginName: string;
  startActivityForResult(options: CapacitorIntentOptions): Promise<any>;
}
