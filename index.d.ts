// Type definitions for react-native-orientation-listener
// Project: https://github.com/walmartlabs/react-native-orientation-listener
// Definitions by: Kyle Roach <https://github.com/iRoachie>
// TypeScript Version: 2.3.2

interface OrientationState {
  orientation: 'PORTRAIT' | 'LANDSCAPE'
  device: string
}

export default class Orientation {
  static addListener: (props: OrientationState) => void
  static getOrientation: (handler: (props: OrientationState) => void) => void
  static removeListener: (handler: (props: OrientationState) => void) => void
}