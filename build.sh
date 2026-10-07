#!/usr/bin/env bash
# Compiles every source file into out/.
# Usage: ./build.sh
set -euo pipefail

cd "$(dirname "$0")"

rm -rf out
mkdir -p out
find src -name '*.java' > out/sources.txt
javac -encoding UTF-8 -d out @out/sources.txt

echo "Compiled $(wc -l < out/sources.txt) files into out/"
