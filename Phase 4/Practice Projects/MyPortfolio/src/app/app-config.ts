export class Config {

  static theme_arr = ['vertical', 'collapsed'];
  static themeType_arr = ['default', 'dark', 'light']

  // public static config = {
  //   theme: 'collapsed', // vertical, collapsed, horizontal
  //   themeType: 'light' // default, dark, light
  // };

  public static config = {
    theme: Config.theme_arr[Math.floor(Math.random() * Config.theme_arr.length)],
    themeType: Config.themeType_arr[Math.floor(Math.random() * Config.themeType_arr.length)]
  };

}
