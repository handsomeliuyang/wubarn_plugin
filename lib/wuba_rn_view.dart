import 'dart:async';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter/foundation.dart';

class WubaRNView extends StatefulWidget {

    @override
    _WubaRNViewState createState() => _WubaRNViewState();
}

class _WubaRNViewState extends State<WubaRNView> {

    @override
    Widget build(BuildContext context) {
        if (defaultTargetPlatform == TargetPlatform.android) {
            return AndroidView(
                viewType: 'plugins.wuba.com/wubarnview',
                onPlatformViewCreated: _onPlatformViewCreated,
            );
        }
        return Text(
            '$defaultTargetPlatform is not yet supported by the WubaRNView plugin');
    }

    void _onPlatformViewCreated(int id) {

    }
}


