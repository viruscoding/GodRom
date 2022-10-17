#!/bin/bash

#set -ex

git config --global user.email "thanatos@aosp.local"
git config --global user.name "thanatos"

TEST_BRANCH=${TEST_BRANCH:-android-10.0.0_r2}
TEST_URL=${TEST_URL:-https://mirrors.tuna.tsinghua.edu.cn/git/AOSP/platform/manifest}

repo init --depth 1 -u "$TEST_URL" -b "$TEST_BRANCH"

echo ¨================start repo sync===============¨

repo sync

while [ $? == 1 ]; do
echo ¨================sync failed, re-sync again=============¨
sleep 3
repo sync
done
