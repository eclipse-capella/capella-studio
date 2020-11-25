#!/bin/sh
# ====================================================================
# Copyright (c) 2006, 2017 THALES GLOBAL SERVICES.
# This program and the accompanying materials are made available under the
# terms of the Eclipse Public License 2.0 which is available at
# http://www.eclipse.org/legal/epl-2.0
#
# SPDX-License-Identifier: EPL-2.0
#
# Contributors:
#     Thales - initial API and implementation
# ====================================================================

# ====================================================================
#
# This script Publish update site from runtime core build to
# to http://download.eclipse.org/kitapha/updates
#
# ====================================================================


[ -z "$WORKSPACE" ] && {
     echo "Execution aborted.


The required variable WORKSPACE is not set. They are normally
provided by the Hudson build.
"
    exit 1
}

# Component name
export COMPONENT_NAME="sdk"
# Update project name
export UPDATE_PRJ_NAME="org.polarsys.capella.studio.releng.updatesite"
# Target update project path
export UPDATE_PATH="releng/plugins/$UPDATE_PRJ_NAME"


# Achived Manifest Name
TARGET_MANIFEST_NAME="Manifest$COMPONENT_NAME.txt"
# Extract Achived manifest file.
TARGET_MANIFEST_FOLDER="$UPDATE_PATH/target"

# Get folder path contain this script
BASEDIR=$(dirname $0)
# Get script name
SCRIPT_NAME=$(basename $0)

# Extract global and release parameters (ie VERSION)
if [ "$LOG" = "true" ]; then
	echo ">>> Run cmd 1 ReleaseUpdateSdk.sh start : . $BASEDIR/global-parameters.sh $BUILD_TYPE"
fi
# Extract global parameters (ie Publish path)
. $BASEDIR/global-parameters.sh $BUILD_TYPE
if [ "$LOG" = "true" ]; then
	echo ">>> Run cmd 1 ReleaseUpdateSdk.sh start : . $BASEDIR/release-parameters.sh $PRODUCT_NAME $COMPONENT_NAME $BUILD_TYPE"
fi
# Extract global parameters (ie VERSION)
. $BASEDIR/release-parameters.sh $PRODUCT_NAME $COMPONENT_NAME $BUILD_TYPE
if [ "$LOG" = "true" ]; then
	echo ">>> Run cmd 1 ReleaseUpdateSdk.sh end"
fi

# Run release publish for this component
if [ "$LOG" = "true" ]; then
	echo ">>> Run cmd 2 ReleaseUpdateSdk.sh start : . $BASEDIR/ReleaseUpdate.sh $COMPONENT_NAME $TARGET_MANIFEST_NAME $TARGET_MANIFEST_FOLDER $BUILD_TYPE $BUILD_TYPE_PREFIX $BUILD_VERSION"
fi
. $BASEDIR/ReleaseUpdate.sh $COMPONENT_NAME $TARGET_MANIFEST_NAME $TARGET_MANIFEST_FOLDER $BUILD_TYPE $BUILD_TYPE_PREFIX $BUILD_VERSION
if [ "$LOG" = "true" ]; then
	echo ">>> Run cmd 2 ReleaseUpdateSdk.sh end"
fi
