FROM openjdk:11.0.5-jdk-stretch

ENV OC_URL=https://github.com/openshift/origin/releases/download/v3.11.0/openshift-origin-client-tools-v3.11.0-0cbc58b-linux-64bit.tar.gz \
    OC_TMP=/tmp/oc.tar.gz \
    DEBIAN_VERSION=stretch \
    DEBIAN_FRONTEND=noninteractive

RUN apt-get update -qq \
    && apt-get install -y -qq wget rsync zip unzip vim telnet \
    && echo "deb http://apt.postgresql.org/pub/repos/apt/ $DEBIAN_VERSION-pgdg main" >> /etc/apt/sources.list \
    && wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | apt-key add - \
    && apt-get update -qq \
    && apt-get install -y -qq postgresql-client-11 \
    && wget -qO ${OC_TMP} ${OC_URL} \
    && tar -xvzf ${OC_TMP} -C /opt/ \
    && mv /opt/openshift* /opt/oc \
    && mkdir -p /opt/bin \
    && ln -s /opt/oc/oc /bin/oc \
    && rm -rf /tmp/hsperfdata_root ${OC_TMP} \
    && oc --loglevel 7 version
