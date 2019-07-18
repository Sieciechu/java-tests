#!/usr/bin/env bash

docker image build -t digitsum-test . && docker container run --rm -it digitsum-test
