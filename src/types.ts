import type { ColorValue } from 'react-native';

type SystemBarStyle = 'light-content' | 'dark-content';

type StatusBarProps = {
  animated?: boolean;
  backgroundColor?: ColorValue | null;
  barStyle: SystemBarStyle;
};

type NavigationBarProps = {
  barStyle: SystemBarStyle;
};

type SystemBarsProps = StatusBarProps;

export {
  type SystemBarStyle,
  type StatusBarProps,
  type NavigationBarProps,
  type SystemBarsProps,
};
