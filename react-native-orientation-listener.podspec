Pod::Spec.new do |s|
  s.name             = "react-native-orientation-listener"
  s.version          = "0.0.2"
  s.summary          = " react-native library for obtaining current device orientation"
  s.requires_arc = true
  s.author       = { 'Ken Wheeler' => 'ken@outlook.com' }
  s.license      = 'MIT'
  s.homepage     = 'https://github.com/walmartreact/react-native-orientation-listener'
  s.source       = { :git => "https://github.com/walmartreact/react-native-orientation-listener.git" }
  s.platform     = :ios, "7.0"
  s.dependency 'React'
  s.source_files     = "*.{h,m}"
  s.preserve_paths   = "*.js"
end
