#!/usr/bin/env bash

docker image build -t decimalcomparator . && docker container run --rm -it decimalcomparator