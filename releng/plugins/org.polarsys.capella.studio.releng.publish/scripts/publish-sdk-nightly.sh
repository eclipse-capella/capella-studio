#!/bin/sh
# ====================================================================
# Copyright (c) 2006, 2020 THALES GLOBAL SERVICES.
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


[ -z "$WORKSPACE" -o -z "$GIT_BRANCH" ] && {
     echo "Execution aborted.

One or more of the required variables is not set. They are normally
provided by the Hudson build.

- WORKSPACE  : the build workspace root.
- GIT_BRANCH : the name fo the Git branch being build/published.
"
    exit 1
}

######################################################################
# Setup
######################################################################

# Exit on error
set -e

# Component name
export COMPONENT_NAME="sdk"
# Update project name
export UPDATE_PRJ_NAME="org.polarsys.capella.studio.releng.updatesite"
# Target update project path
export UPDATE_PATH="releng/plugins/$UPDATE_PRJ_NAME"
# The type of build being published
export BUILD_TYPE="nightly"
export BUILD_TYPE_PREFIX="N"

# Get folder path contain this script
BASEDIR=$(dirname $0)
# Get script name
SCRIPT_NAME=$(basename $0)

# Extract global parameters (ie Publish fix part location)
. $BASEDIR/global-parameters.sh $BUILD_TYPE

# Extract publish parameters (ie VERSION)
. $BASEDIR/publish-parameters.sh $COMPONENT_NAME $BUILD_TYPE $BUILD_TYPE_PREFIX

# Run nightly publish for this component
. $BASEDIR/publish-nightly.sh $PRODUCT_NAME $COMPONENT_NAME $UPDATE_PRJ_NAME $UPDATE_PATH $VERSION $BUILD_TYPE $BUILD_TYPE_PREFIX $TARGET_PATH
