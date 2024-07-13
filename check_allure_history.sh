#!/bin/bash

if [ -d "public" ]; then
    echo "public directory found. Performing additional actions."
    ls -la
    cp -r "public/history" allure-results
    rm -rf "public"

    echo "Actions completed successfully."
else
    echo "Warning: public directory not found."
fi