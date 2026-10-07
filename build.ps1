# Compiles every source file into out\.
# Usage: .\build.ps1
$ErrorActionPreference = 'Stop'

Set-Location $PSScriptRoot

if (Test-Path out) { Remove-Item -Recurse -Force out }
New-Item -ItemType Directory out | Out-Null

$sources = Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName }
$sources | Out-File -Encoding utf8 out\sources.txt

javac -encoding UTF-8 -d out "@out\sources.txt"
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }

Write-Output "Compiled $($sources.Count) files into out\"
