
check_folder(){
	typeCheck=$1
	folderToCheck=$2
	echo "$typeCheck release : List of file and folder $folderToCheck/"
	if [ -d $folderToCheck ]; then
		ls -al $folderToCheck/
	fi
}

# Get folder path contain this script
BASEDIR=$(dirname $0)

. $BASEDIR/global-parameters.sh $BUILD_TYPE

if [ "$LOG" = "true" ]; then
	check_folder Before $PUBLISH_FOLDER_ROOT/updates/release/sdk
	check_folder Before $PUBLISH_FOLDER_ROOT/products/release
	check_folder Before $PUBLISH_FOLDER_ROOT/updates/milestone/sdk
	check_folder Before $PUBLISH_FOLDER_ROOT/products/milestone
	check_folder Before $PUBLISH_FOLDER_ROOT/updates/stable/sdk
	check_folder Before $PUBLISH_FOLDER_ROOT/products/stable
	echo "Before release : df -h $PUBLISH_FOLDER_ROOT"
	df -h $PUBLISH_FOLDER_ROOT
fi

echo "Launch the release of Capella studio"
. $BASEDIR/ReleaseProducts.sh
. $BASEDIR/ReleaseUpdateSdk.sh

if [ "$LOG" = "true" ]; then
	check_folder After $PUBLISH_FOLDER_ROOT/updates/release/sdk
	check_folder After $PUBLISH_FOLDER_ROOT/products/release
	check_folder After $PUBLISH_FOLDER_ROOT/updates/milestone/sdk
	check_folder After $PUBLISH_FOLDER_ROOT/products/milestone
	check_folder After $PUBLISH_FOLDER_ROOT/updates/stable/sdk
	check_folder After $PUBLISH_FOLDER_ROOT/products/stable
	echo "After release : df -h /home/data/httpd/download.polarsys.org/kitalpha"
	df -h $PUBLISH_FOLDER_ROOT
fi
