#!/bin/sh

# This requires enwman and html-reporter being previouslly installed
# If needed, run: npm install -g newman newman-reporter-htmlextra
newman run ./postman/collection.json -r htmlextra  --bail --reporter-htmlextra-export /tmp/report.html
