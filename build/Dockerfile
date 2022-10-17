FROM ubuntu:18.04

ARG userid=1000
ARG groupid=1000
ARG username=aosp

RUN apt-get update && apt-get install -qqy git-core gnupg flex bison gperf build-essential zip curl zlib1g-dev gcc-multilib g++-multilib x11proto-core-dev libx11-dev libgl1-mesa-dev libxml2-utils xsltproc unzip python python3.7 openjdk-8-jdk rsync

# kernel
RUN apt-get update && apt-get install -qqy bc liblz4-tool

RUN ln -s /usr/bin/python3.7 /usr/bin/python3

RUN curl -o /usr/local/bin/repo https://mirrors.tuna.tsinghua.edu.cn/git/git-repo
RUN chmod a+x /usr/local/bin/repo
RUN echo "export REPO_URL='https://mirrors.tuna.tsinghua.edu.cn/git/git-repo/'" >> ~/.bashrc

RUN rm -rf /var/cache/apt && rm -rf /var/lib/apt/lists

RUN groupadd -g $groupid $username && \
    useradd -m -u $userid -g $groupid $username

USER $username

VOLUME ["/aosp"]

# aosp不再提供ccache，没有性能提升
# ENV USE_CCACHE 1
# ENV CCACHE_DIR /tmp/ccache

# Work in the build directory, repo is expected to be init'd here
WORKDIR /aosp
