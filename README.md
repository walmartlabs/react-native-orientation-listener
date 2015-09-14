## react-native-orientation-listener

> A react-native library for obtaining current device orientation

###Getting Started

- Run `npm install --save react-native-orientation-listener`
- Open your Xcode project, and select your project in the Project Navigator tab
- Right click the `Libraries` folder and select "Add files to [your project]"
- Add `RCTOrientationListener.xcodeproj` from your `node_modules` folder
- Click your main project icon back in the Project Navigator to bring up preferences, and go to the `Build Phases` tab.
- Click the `+` button underneath `Link Binary With Libraries` section.
- Add `libRCTOrientationListener.a`

###Usage

Import the library:

```
var Orientation = require('react-native-orientation-listener');
```

####getOrientation(callback)

This method will return the current orientation and device string in the form of a callback:

```
componentDidMount(){
  Orientation.getOrientation(
    (orientation, device) => {
      console.log(orientation, device);
    }
  );
}
```

####addListener(callback)

This method will add a listener that will call the callback anytime the device orienatation changes:

```
_setOrientation(data) {
  this.setState({
    orientation: evt.orientation,
    device: evt.device
  });
},
componentDidMount(){
  Orientation.addListener(this._setOrientation);
}
```

####removeListener(callback)

This method removes the listener you added in componentDidMount:

```
componentWillUnmount() {
  Orientation.removeListener(this._setOrientation);
}
```