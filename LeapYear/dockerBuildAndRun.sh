#!/usr/bin/env bash

docker image build -t leapyear-test . && docker container run --rm -it leapyear-test