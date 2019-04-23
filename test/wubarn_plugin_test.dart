import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:wubarn_plugin/wuba_rn_view.dart';

void main() {
  const MethodChannel channel = MethodChannel('wubarn_plugin');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
//    expect(await WubaRNView.platformVersion, '42');
  });
}
