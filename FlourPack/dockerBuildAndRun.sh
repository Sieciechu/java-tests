#!/usr/bin/env bash

docker image build -t flourpack-test . && docker container run --rm -it flourpack-test
