# rn-edge-to-edge

### ReactNative - apply 'Edge-to-edge' mode for android platform

## Installation

```sh
npm install rn-edge-to-edge
```


## Setup
### Android

1. Add inside your `android/app/src/main/java/com/yourprojectname/MainActivity.{java,kt}` file:

```
import androidx.activity.enableEdgeToEdge

class MainActivity: ReactActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
      ...
      enableEdgeToEdge()
      super.onCreate(null);
  }

  ...
}
```
## Usage

```js
import { StatusBar } from 'rn-edge-to-edge';

// ...

return (
    <NavigationContainer
      linking={platformLinking}
      theme={Theme}
      onReady={isReadyCallback}>
        <StatusBar 
            barStyle='dark-content'
            backgroundColor='#ff007c'
        />
        <RootStack />
    </NavigationContainer>
  );
```

### Props
```
    barStyle: "light-content" | "dark-content";
    animated = boolean
    backgroundColor = ColorValue | null
```
ℹ️ **If you using prop "backgroundColor" equal to "null", the navigationBar will be transparent** 


## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
