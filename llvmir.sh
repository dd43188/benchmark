#!/bin/bash

IOSBC=$PWD/benchmark/build/bin/iosArm64/releaseShared/
OHOSBC=$PWD/benchmark/build/bin/ohosArm64/releaseShared/

/Users/jiamiao/Documents/arkui-sdk/HarmonyOS-NEXT-DP2/base/native/llvm/bin/llvm-dis $OHOSBC/out.bc -o $OHOSBC/ohos.ll
# 优化IR
#/Users/jiamiao/Documents/workspace_kmm/llvm-distributions/bin/opt -O3 $OHOSBC/ohos.ll -o $OHOSBC/ohos_optimized.ll


/Users/jiamiao/Documents/arkui-sdk/HarmonyOS-NEXT-DP2/base/native/llvm/bin/llvm-dis $IOSBC/out.bc -o $PWD/benchmark/build/bin/iosArm64/releaseShared/ios.ll



